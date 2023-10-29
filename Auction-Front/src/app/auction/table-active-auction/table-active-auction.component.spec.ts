import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableActiveAuctionComponent } from './table-active-auction.component';

describe('TableActiveAuctionComponent', () => {
  let component: TableActiveAuctionComponent;
  let fixture: ComponentFixture<TableActiveAuctionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableActiveAuctionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableActiveAuctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
