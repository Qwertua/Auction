import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddingLotComponent } from './adding-lot.component';

describe('AddingLotComponent', () => {
  let component: AddingLotComponent;
  let fixture: ComponentFixture<AddingLotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddingLotComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddingLotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
